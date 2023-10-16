package com.company.loanapi.repository;

import com.company.loanapi.domain.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public int create(Address address) {
        String sql = "INSERT INTO address (country, city, street, postal_code) " +
                "VALUES(:country, :city, :street, :postalCode)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("country", address.getCountry());
        params.addValue("city", address.getCity());
        params.addValue("street", address.getStreet());
        params.addValue("postalCode", address.getPostalCode());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql, params, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
