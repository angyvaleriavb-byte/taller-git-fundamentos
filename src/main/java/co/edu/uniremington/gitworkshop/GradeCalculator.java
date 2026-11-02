package co.edu.uniremington.gitworkshop;

public class GradeCalculator {

  static final double WEIGHT = 0.25;
  static final double PASSING_GRADE = 3.0;

  static final double UMBRAL_EXCELENTE = 4.5;
    static final double UMBRAL_BUENO = 4.0;
    static final double UMBRAL_ACEPTABLE = 3.0;

  public static void main(String[] args) {
    double coursework = readGrade("Seguimiento");
    double midterm1 = readGrade("Parcial 1");
    double midterm2 = readGrade("Parcial 2");
    double project = readGrade("Proyecto");

    double finalGrade = finalGrade(coursework, midterm1, midterm2, project);
    IO.println("Nota definitiva: %.1f".formatted(finalGrade));
    if (passed(finalGrade)) {
            IO.println("Aprobó el curso.");
        }
  }

  static double finalGrade(double coursework, double midterm1,
      double midterm2, double project) {
    return (coursework + midterm1 + midterm2 + project) * WEIGHT;
  }
  static boolean passed(double grade) {
        return grade >= PASSING_GRADE;
    }

    static String obtenerDesempeno(double definitiva) {
        if (definitiva >= UMBRAL_EXCELENTE) return "Excelente";
        if (definitiva >= UMBRAL_BUENO) return "Bueno";
        if (definitiva >= UMBRAL_ACEPTABLE) return "Aceptable";
        return "Insuficiente";
    }

  static double readGrade(String component) {
    String input = IO.readln(component + ": ");
    return Double.parseDouble(input.strip());
  }
}
