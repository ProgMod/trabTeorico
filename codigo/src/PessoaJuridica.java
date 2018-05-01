public class PessoaJuridica extends Pessoa {
    int [] CNPJ;

    public PessoaJuridica(int[] CNPJ) {
        setCNPJ(CNPJ);
    }

    public int[] getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int[] CNPJ) {
        this.CNPJ = CNPJ;
    }
}
