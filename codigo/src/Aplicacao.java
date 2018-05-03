import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Aplicacao {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter logErro = new PrintWriter("erro.log");
        try {


            Ano ano = (a) -> {
                if (a % 400 == 0) {
                    return true;
                } else return (a % 4 == 0) && (a % 100 != 0);
            };

            DataLambda d = new DataLambda();
            if (ano.eAnoBisexto(d.getAno()))
                System.out.println(d.getAno() + " e ano bissexto");
            else
                System.out.println(d.getAno() + " nao e ano bissexto");

            DataLambda d2 = new DataLambda(2016, 3, 20);

            if (ano.eAnoBisexto(d2.getAno()))
                System.out.println(d2.getAno() + " e ano bissexto");
            else
                System.out.println(d2.getAno() + " nao e ano bissexto");




            Mes mes = (m) -> {
                if (ano.eAnoBisexto(m.getAno())) {
                    m.setDiasMes();
                }
                return m.getDiasMes(m.getMes() - 1);
            };
            System.out.println(d2.getNomeMes(d2.getMes() - 1 ) + " = " + mes.diasNoMes(d2) + " dias");
            d2.setMes(2);
            System.out.println(d2.getNomeMes(d2.getMes() - 1 ) + " = " + mes.diasNoMes(d2) + " dias");


            Semana sem = (s) -> {
                int i = LocalDate.of(s.getAno(), s.getMes(), s.getDia()).getDayOfWeek().getValue();
                return s.getNomeDaSemana(i - 1);
            };
            System.out.println(sem.diaDaSemana(d));



        } catch (ExcecaoDataInvalida e) {
            e.printStackTrace(logErro);
        } finally {
            logErro.close();
        }
    }

}
