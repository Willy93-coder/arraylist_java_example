import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList();

        // El arrayList genera 10 posiciones por defecto.
        // Usamos el metodo ensureCapacity() para definir cuantos posiciones debe crear
        // y asi optimizamos memoria al asignarle por defecto 5 posiciones y no 10.
        // La recomendacion es usarlo cuando sabemos que no va a pasar de X posiciones.
        //listaEmpleados.ensureCapacity(5);

        listaEmpleados.add(new Empleado("Antonio", 2300, 2005, 7, 5));
        listaEmpleados.add(new Empleado("Maria", 3444, 2009, 8, 20));
        listaEmpleados.add(new Empleado("Rosa", 8765, 2004, 2, 12));
        listaEmpleados.add(new Empleado("Juan", 5441, 2007, 5, 22));
        listaEmpleados.add(new Empleado("Manuel", 9000, 2015, 3, 25));

        // Optimizamos memoria
        // Por defecto el arrayList genera 10 posiciones, sino ocupamos todas las posiciones
        // usamos el metodo trimToSize() para que se ajuste a las posiciones que tenemos
        // en este caso 5 y asi evitamos malgastar memoria.
        // listaEmpleados.trimToSize();

        // Reemplazo de elemento
        listaEmpleados.set(1, new Empleado("Jorge", 1990, 2006, 4, 2));

        // Acceder a la informacion concreta de un elemento
        System.out.println(listaEmpleados.get(3).getNombre());

        // Eliminar elemento
        listaEmpleados.remove(0);

        // Diferentes formas de recorrer un array
        // Bucle forEach
        System.out.println(listaEmpleados.size());
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.getNombre() + " y un salario de " + empleado.getSueldo());
        }

        // Bucle for normal
        /*
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.getNombre());
        } */

        // Creamos un array sobre el arrayList
        /* Empleado empleadoArray[] = new Empleado[listaEmpleados.size()];
        listaEmpleados.toArray(empleadoArray);

        for (int i = 0; i < empleadoArray.length; i++){
            System.out.println(empleadoArray[i].getNombre());
        } */

        // Iterators
        Iterator<Empleado> iteradorEmpleado = listaEmpleados.iterator();
        while (iteradorEmpleado.hasNext()) System.out.println(iteradorEmpleado.next());

    }
}

class Empleado {

    private static final long serialVersionUID = 1L;

    public Empleado(String n, double s, int agno, int mes, int dia) {

        nombre = n;

        sueldo = s;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);

        fechaContrato = calendario.getTime();

    }


    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }


    public void subirSueldo(double porcentaje) {

        double aumento = sueldo * porcentaje / 100;

        sueldo += aumento;

    }

    public String toString() {

        return "El Nombre es =" + nombre + ",y su sueldo es =" + sueldo + ", fecha de contrato=" + fechaContrato;

    }

    private String nombre;

    private double sueldo;

    private Date fechaContrato;

}
