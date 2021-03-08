package service;

import model.Client;

public interface ClientServiceIn {

    boolean addClient(Client client);

    boolean deleteClient(int id);

    Client getClient(int id);

    Client[] getAllClient();
}
