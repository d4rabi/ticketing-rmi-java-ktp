/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Annisa
 */

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.*;

public interface IBioskop extends Remote {
    public List<Bioskop> getBioskops() throws Exception;
}
