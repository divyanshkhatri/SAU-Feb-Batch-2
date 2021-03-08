package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Client;

public class ClientService implements ClientServiceIn {

    private static final Map<Integer, Client> clients = new HashMap<>();

    @Override
    public boolean addClient(Client client) {
        if (clients.get(client.getId()) != null) {
        	return false;
		}
        clients.put(client.getId(), client);
        return true;
    }

    @Override
    public boolean deleteClient(int id) {
        if (clients.get(id) == null) {
        	return false;
		}
        clients.remove(id);
        return true;
    }

    @Override
    public Client getClient(int id) {
        return clients.get(id);
    }

    @Override
    public Client[] getAllClient() {
        Set<Integer> ids = clients.keySet();
        Client[] clients = new Client[ids.size()];
        int i = 0;
        for (Integer id : ids) {
            clients[i] = ClientService.clients.get(id);
            i++;
        }
        return clients;
    }
}
