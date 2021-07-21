import java.util.Random;

public class CuentaBancoTest {
    
    private String numeroCuenta = "";
    private Double saldoCuentaCorriente = 0.0;
    private Double saldoCuentaAhorro = 0.0;
    private static int cuentasCreadas = 0;
    private static Double dineroAlmacenado = 0.0;

    public CuentaBancoTest() {
        numeroCuenta = nuevaCuenta();
        saldoCuentaCorriente = 0.0;
        saldoCuentaAhorro = 0.0;
        cuentasCreadas += 1;
        System.out.println("nuevo usuario creo una cuenta: " + numeroCuenta);
        System.out.println("total de cuentas creadas: " + cuentasCreadas);
    }

    public Double getSaldoCuentaCorriente() {
        return saldoCuentaCorriente;
    }

    public void setSaldoCuentaCorriente(Double saldoCuentaCorriente) {
        this.saldoCuentaCorriente = saldoCuentaCorriente;
    }

    public Double getSaldoCuentaAhorro() {
        return saldoCuentaAhorro;
    }

    public void setSaldoCuentaAhorro(Double saldoCuentaAhorro) {
        this.saldoCuentaAhorro = saldoCuentaAhorro;
    }

    private String nuevaCuenta() {
        String numero = "0123456789";
        String numeroR = "";

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char num = numero.charAt(random.nextInt(10));
            numeroR += num;
        }
        numeroCuenta = numeroR;
        return numeroR;
    }

    public void deposito(String cuentas, Double total) {
        if (cuentas == "corriente" || cuentas == "Corriente") {
            setSaldoCuentaCorriente(getSaldoCuentaCorriente() + total);
            dineroAlmacenado += total;
        }
        if (cuentas == "ahorros" || cuentas == "Ahorros") {
            setSaldoCuentaAhorro(getSaldoCuentaAhorro() + total);
            dineroAlmacenado += total;
        } else {
            System.out.println("Elije tipo de cuenta");
            ;
        }
    }

    public void retiro(String cuentas, Double totalRetiro) {
        if (cuentas == "corriente" || cuentas == "Corriente") {
            if (getSaldoCuentaCorriente() < totalRetiro) {
                System.out.println("saldo insuficiente");
            } else {
                setSaldoCuentaCorriente(getSaldoCuentaCorriente() - totalRetiro);
                dineroAlmacenado -= totalRetiro;
            }
        }
        if(cuentas == "ahorros" || cuentas == "Ahorros"){
            if(getSaldoCuentaAhorro() < totalRetiro) {
                System.out.println("saldo insuficiente");
            }
            else {
                setSaldoCuentaAhorro(getSaldoCuentaAhorro() - totalRetiro);
                dineroAlmacenado -= totalRetiro;
            }
        }
    }

    public Double totalAhorros() {
        Double ahorrosTotal = saldoCuentaCorriente + saldoCuentaAhorro;
        System.out.println(ahorrosTotal);
        return ahorrosTotal;
    }
}
