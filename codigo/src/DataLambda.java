import java.time.LocalDate;

public class DataLambda implements Ordenavel {
    private int ano, mes, dia;

    private static final int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] nomeMes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static final String[] nomeDaSemana = {"Segunda-Feira", "Terca-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado", "Dommingo"};

    DataLambda(int ano, int mes, int dia) throws ExcecaoDataInvalida {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    DataLambda() {
        this.dia = LocalDate.now().getDayOfMonth();
        this.mes = LocalDate.now().getMonthValue();
        this.ano = LocalDate.now().getYear();

    }

    void adicionaDias(int dias) {
        this.dia += dias;
        if (getDia() > diasMes[getMes() - 1]) {
            this.dia = getDia() - diasMes[getMes() - 1];
            this.mes++;
            if (getMes() == 13) {
                this.mes = 1;
                this.ano++;
            }
        }
    }

    void proximoDia() {
        adicionaDias(1);
    }

    public void setAno(int ano) throws ExcecaoDataInvalida {
        if (ano < 0)
            throw new ExcecaoDataInvalida(ano, "ano");
        else
            this.ano = ano;
    }

    public void setMes(int mes) throws ExcecaoDataInvalida {
        if (mes < 1 || mes > 12)
            throw new ExcecaoDataInvalida(mes, "mes");
        else
            this.mes = mes;
    }

    public void setDia(int dia) throws ExcecaoDataInvalida {
        if (dia < 0 || dia > 31)
            throw new ExcecaoDataInvalida(dia, "dia");
        else if (dia > diasMes[this.getMes() - 1])
            throw new ExcecaoDataInvalida(dia, "dia");
        else
            this.dia = dia;
    }

    public void setDiasMes(){
        diasMes[1] = 29;
    }

    int getAno() {
        return ano;
    }

    int getMes() {
        return mes;
    }

    int getDia() {
        return dia;
    }

    int getDiasMes(int pos){
        return diasMes[pos];
    }

    String getNomeMes(int pos){
        return nomeMes[pos];
    }

    String getNomeDaSemana(int pos){
        return nomeDaSemana[pos];
    }

    @Override
    public String toString() {
        return getDia() + " de " + nomeMes[getMes() - 1] + " de " + getAno();
    }

    @Override
    public boolean menorQue(Ordenavel o) {
        Data d = (Data) o;
        if (this.getAno() < d.getAno()) {
            return true;
        } else if (this.getAno() == d.getAno()) {
            if (this.getMes() < d.getMes()) {
                return true;
            } else if (this.getMes() == d.getMes()) {
                return this.getDia() < d.getDia();
            }
        }
        return false;
    }
}
