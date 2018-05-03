import java.time.LocalDate;

public class Data implements Ordenavel {
    private int ano, mes, dia;

    private static final int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] nomeMes = {"Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static final String[] nomeDaSemana = {"Segunda-Feira", "Terca-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado", "Dommingo"};

    Data(int ano, int mes, int dia) throws ExcecaoDataInvalida {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    Data() {
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

    int diasNoMes() {
        if (eAnoBisexto()) {
            diasMes[1] = 29;
        }
        return diasMes[getMes() - 1];
    }

    String diaDaSemana() {
        int i = LocalDate.of(getAno(), getMes(), getDia()).getDayOfWeek().getValue();
        return nomeDaSemana[i - 1];
    }

    boolean eAnoBisexto() {
        if (ano % 400 == 0) {
            return true;
        } else return (ano % 4 == 0) && (ano % 100 != 0);
    }

    void proximoDia() {
        adicionaDias(1);
    }

    String porExtenso() {
        return getDia() + " de " + nomeMes[getMes() - 1] + " de " + getAno();
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

    int getAno() {
        return ano;
    }

    int getMes() {
        return mes;
    }

    int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return porExtenso();
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
