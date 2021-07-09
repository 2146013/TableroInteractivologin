package co.edu.escuelaing.interactivebalckboardlife.repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Memory {
    private static final Memory instance = new Memory();
    private final List<String> ticketList;
    private String ticketNumber;

    public Memory(){
        ticketList = new CopyOnWriteArrayList<>();
        ticketNumber = UUID.randomUUID().toString();
    }

    public static Memory getInstance(){
        return instance;
    }

    public synchronized String setTicketNumber(String ipAddress){
        ticketNumber = ipAddress + "password";
        ticketList.add(ticketNumber);
        return ticketNumber;
    }

    public boolean checkTicket(String ticketNumber){
        boolean isValid = false;
        if (ticketList.contains(ticketNumber)) {
            isValid = true;
        }
        return isValid;
    }
}