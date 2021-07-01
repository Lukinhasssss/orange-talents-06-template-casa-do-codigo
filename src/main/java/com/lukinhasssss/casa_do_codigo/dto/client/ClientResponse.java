package com.lukinhasssss.casa_do_codigo.dto.client;

import com.lukinhasssss.casa_do_codigo.entities.Client;

public class ClientResponse {

    private Long id;

    public ClientResponse(Client client) {
        id = client.getId();
    }

    public Long getId() {
        return id;
    }

}
