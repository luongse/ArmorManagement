package luongnd.Server2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import luongnd.dto.ArmorDTO;

public interface ArmorInterface extends Remote{
    boolean createArmor(ArmorDTO dto) throws RemoteException;
    List<ArmorDTO> findAllArmor() throws RemoteException;
    boolean removeArmor(String id) throws RemoteException;
    boolean updateArmor(ArmorDTO dto) throws RemoteException;
}
