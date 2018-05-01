public class PessoaFisica extends Pessoa {
    int [] CPF;

    public PessoaFisica(int[] CPF) {
        setCPF(CPF);
    }

    public int[] getCPF() {
        return CPF;
    }

    public void setCPF(int[] CPF) {
        this.CPF = CPF;
    }
}
