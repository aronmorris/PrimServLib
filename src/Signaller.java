import java.util.ArrayList;
import java.util.List;

public class Signaller {

    enum SIGNAL {
        GET,
        POST,
        ROOT
    }

    private static List<Observer> observers = new ArrayList<Observer>();

    public static SIGNAL currentSignal;

    public static void attach(Observer observer){
        observers.add(observer);
    }

    //pass the signal up to the server
    public static void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static void sendSignal(SIGNAL signal) {

        currentSignal = signal;

        switch(signal) {
            case GET: GETProtocol();
                break;
            case POST: POSTProtocol();
                break;
            case ROOT: ROOTProtocol();
                break;
            default: INVALIDProtocol();
                break;
        }

    }

    private static void GETProtocol() {



        notifyAllObservers();

    }

    private static void POSTProtocol() {}

    private static void ROOTProtocol() {

        notifyAllObservers();

    }

    private static void INVALIDProtocol() {}

    public static String getRoot(String dirContents) {

        return dirContents;

    }

}
