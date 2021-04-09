package luongnd.Server2;

import luongnd.dto.ArmorDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import luongnd.dao.FileDAO;

public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    List<ArmorDTO> listArmor = new ArrayList<>();
    static String filename = "ArmorData.txt";

    public ArmorServer() throws RemoteException {
    }

    @Override
    public boolean createArmor(ArmorDTO dto) {
        try {
            listArmor.add(dto);
            boolean checkWrite = FileDAO.writeFile(listArmor, filename);
            
            return checkWrite == true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArmorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ArmorDTO> findAllArmor() throws RemoteException {
        listArmor = FileDAO.openFile(filename);

        return listArmor;
    }

    @Override
    public boolean removeArmor(String id) {
        for (int i = 0; i < listArmor.size(); i++) {
            if (id.equalsIgnoreCase(listArmor.get(i).getArmorID())) {
                listArmor.remove(i);

                try {
                    FileDAO.writeFile(listArmor, filename);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) throws RemoteException {

       boolean result = false;
        List<ArmorDTO> list = findAllArmor();
        if (list != null) {
            for (ArmorDTO armorDTO : list) {
                if (armorDTO.getArmorID().equals(dto.getArmorID())) {
                    armorDTO.setClassification(dto.getClassification());
                    armorDTO.setDefense(dto.getDefense());
                    armorDTO.setDescription(dto.getDescription());
                    armorDTO.setStatus(dto.getStatus());
                    armorDTO.setDate(dto.getDate());
                    result = true;
                }
            }
           try {
               FileDAO.writeFile(listArmor, filename);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(ArmorServer.class.getName()).log(Level.SEVERE, null, ex);
           }
        }  
        return result;
    }

    public static void main(String[] args) {

        String serviceName= "rmi://localhost:1098/armor";
        ArmorServer server;
        try{
            server= new ArmorServer();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(serviceName, server);
            System.out.println("Service:" + serviceName + "is running...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
