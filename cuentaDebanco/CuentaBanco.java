public class CuentaBanco {
    public static void main(String[] args) {
        CuentaBancoTest user1 = new CuentaBancoTest();
        CuentaBancoTest user2 = new CuentaBancoTest();

        user1.deposito("Corriente", 8.00);
        user2.deposito("ahorro", 7.00);

        user1.totalAhorros();
        user2.totalAhorros();
    }
}