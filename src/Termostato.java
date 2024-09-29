import java.time.LocalDate;

public class Termostato implements Dispositivos {

private int temperatura;
private LocalDate fechaRevision;
private final int MIN_TEMPERATURA =15;
private final int MAX_TEMPERATURA =80;
private final int INICIAL_TEMPERATURA =20;


public Termostato() {
this.temperatura = INICIAL_TEMPERATURA;
this.fechaRevision = LocalDate.now();
}


@Override
public boolean subir(){
if (temperatura < MAX_TEMPERATURA){
    temperatura++;
    return true;
} return false;
}

@Override
public boolean bajar(){
if (temperatura > MIN_TEMPERATURA){
    temperatura--;
    return true;
} return false;
}

@Override
public String verEstado(){
return "\nTERMOSTATO:\nTemperatura actual:" + temperatura + "\nFecha última revisión:" + fechaRevision;
}

@Override
public void reset(){
    this.temperatura= INICIAL_TEMPERATURA;
}


public void revisar() {
    this.fechaRevision = LocalDate.now();
}

}
