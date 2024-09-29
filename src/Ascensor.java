public class Ascensor implements Dispositivos {

private int piso;
private final int MIN_PISO = 0;
private final int MAX_PISO = 8;
private final int INICIAL_PISO = 0;


public Ascensor() {
    this.piso= INICIAL_PISO;
    }

@Override
public boolean subir(){
    if(piso < MAX_PISO){
        piso++;
        return true;
    }return false;
}

@Override
public boolean bajar(){
    if(piso > MIN_PISO){
        piso--;
        return true;
    }return false;
}

@Override
public void reset(){
    piso = INICIAL_PISO;
    }

@Override
public String verEstado(){
    return "\nASCENSOR:\nUbicación actual. Piso: "+ piso;
}

}
