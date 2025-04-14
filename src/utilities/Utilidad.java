package utilities;

public class Utilidad {

    public static boolean validarCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

    public static boolean validarNombre(String nombre) {
        nombre = nombre.trim().toLowerCase();
        String nombreRegex = "[a-zñ]+(\\s[a-zñ]+)?";
        boolean valid = false;
        if (nombre.matches(nombreRegex)) {
            valid = true;
        }
        return valid;
    }

    
    public static String toMayuscula(String nombre) {
        String[] palabras = nombre.split(" ");
        String[] nueva = new String[palabras.length];
        nombre = "";
        for (int i = 0; i < palabras.length; i++) {
            nueva[i] = palabras[i].toUpperCase().charAt(0) + palabras[i].substring(1, palabras[i].length()).toLowerCase();
            nombre += nueva[i] + " ";
        }
        return nombre;
    }
    
    
    public static boolean validarEmail(String email) {
        email = email.toLowerCase();
        String emailRegex = "^[a-z]+[0-9]{4}(@uta.edu.ec)$";
        boolean valid = false;
        if (email.matches(emailRegex)) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validarMateriaCurso(String materiaCurso) {
        materiaCurso = materiaCurso.toLowerCase();
        String emailRegex = "([a-zñ]+\\s?)+";
        boolean valid = false;
        if (materiaCurso.matches(emailRegex)) {
            valid = true;
        }
        return valid;
    }
    
    public static boolean validarNota(String nota) {
        String notaRegex = "^\\d{1,2}(\\.\\d+)?";
        boolean valid = false;
        if (nota.matches(notaRegex) && Double.parseDouble(nota) <= 10) {
            valid = true;
        }
        return valid;
    }
    
    

}
