public class Pessoa {
    String nome;
    int idade;
    double id;
    Pessoa dado;

    public Pessoa(String nome, int idade, int id, int [] dado) {
        if(dado.length == 11)
            this.dado = new PessoaFisica(dado);
        else
            this.dado = new PessoaJuridica(dado);
        setNome(nome);
        setIdade(idade);
        setId(Math.random());
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
