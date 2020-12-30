package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.AccountNotFoundException;
import Excepcions.ActivitatExceptions.Exceptions.ClientNotFound;
import Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;
import com.company.Menu;

import java.awt.*;
import java.util.List;

public class OperacionsBanc {
    private static final String dniChars="SODPJFOPSJDDFPOSJFPOS";
    public static boolean verifyDNI(String dni) {
        String DNI = dni.trim().replaceAll(" ", "").substring(0, 8);
        char letraDni = dni.charAt(8);
        int numDNI = Integer.parseInt(DNI) % 21;
        if ( dniChars.charAt(numDNI) == letraDni) {
            return true;
        } else {
            return false;
        }
    }
    public static CompteEstalvi verifyAccount(String account) throws AccountNotFoundException {
        CompteEstalvi compteDevolver = null;
        for (CompteEstalvi compteEstalvi : Menu.compteEstalviList) {
            if (compteEstalvi.getNumCompte().equals(account)) {
                compteDevolver = compteEstalvi;
            }
        }

        if (compteDevolver != null) {
            return compteDevolver;
        } else {
            throw new AccountNotFoundException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }
    }
    public static Client buscarCliente(String dni, List<Client> clientList) throws ClientNotFound {
        Client cliente = null;
         for (Client client : clientList) {
             if (dni.equals(client.getDNI())) {
                 cliente = client;
             }
         }
        if (cliente != null) {
            return cliente;
        }
        else {
            throw new ClientNotFound(ExceptionMessage.CLIENT_NOT_FOUND);
        }

    }

}
