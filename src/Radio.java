public class Radio implements Dispositivos{
private double frecuencia;
private final double MIN_FRECUENCIA=88.0;
private final double MAX_FRECUENCIA=104.0;
private final double INICIAL_FRECUENCIA=88.0;

public Radio() {
    this.frecuencia=INICIAL_FRECUENCIA;
    
}


@Override
public boolean subir(){
    if(frecuencia < MAX_FRECUENCIA){
        frecuencia +=0.1;
        return true;
    }return false;

}

@Override
public boolean bajar(){
    if(frecuencia > MIN_FRECUENCIA){
        frecuencia -=0.1;
        return true;
    }return false;

}

@Override
public void reset(){
    frecuencia= INICIAL_FRECUENCIA;
}

@Override
public String verEstado(){
    return "\nRADIO:\nFrecuencia actual: "+ frecuencia;

}

}
