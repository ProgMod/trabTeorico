public class ExcecaoDataInvalida extends Exception {
    public ExcecaoDataInvalida(int num, String tipo){
            super(num + " e um " + tipo + " invalido");
    }
}
