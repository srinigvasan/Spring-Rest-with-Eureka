package com.udacity.vehicles.client.prices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implements a class to interface with the Pricing Client for price data.
 */
@Component
public class PriceClient {

    private static final Logger log = LoggerFactory.getLogger(PriceClient.class);

    private final RestTemplate client;
    @Value("${pricing.endpoint}")
    private String endpoint;

    public PriceClient(RestTemplate pricing) {
        this.client = pricing;
    }

    // In a real-world application we'll want to add some resilience
    // to this method with retries/CB/failover capabilities
    // We may also want to cache the results so we don't need to
    // do a request every time
    /**
     * Gets a vehicle price from the pricing client, given vehicle ID.
     * @param vehicleId ID number of the vehicle for which to get the price
     * @return Currency and price of the requested vehicle,
     *   error message that the vehicle ID is invalid, or note that the
     *   service is down.
     */
    public String getPrice(Long vehicleId) {
        try {
            Price price = client.getForObject(endpoint+"/"+vehicleId, Price.class);

            return String.format("%s %s", price.getCurrency(), price.getPrice());

        } catch (Exception e) {
            log.error("Unexpected error retrieving price for vehicle {}", vehicleId, e);
        }
        return "(consult price)";
    }
}
