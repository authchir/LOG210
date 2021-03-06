package hotel.util;

/**
 * Cette classe est très similaire à la classe java.util.Observable à quelques exception près :
 * 
 * <ul>
 * <li>Elle est templaté avec le type observé.</li>
 * <li>Elle utilise la classe hotel.util.Observer<T> au lieu de java.util.Observer.</li>
 * <li>Il n'est pas nécessaire d'appeler la méthode setChanged() avant notifyObservers().</li>
 * <li>Certaines fonctionnalités n'ont pas été implémentées puisque non nécessaires pour l'instant.</li>
 * </ul>
 * 
 * @param <T>
 *            Le type de l'objet observé.
 */
public class Observable<T> {

    // --------------------------------------------------
    // Constructor(s)

    protected Observable() {

    }

    // --------------------------------------------------
    // Accessor(s)

    // --------------------------------------------------
    // Mutators(s)

    public void addObserver(Observer<T> observer) {
        data.addObserver(observer);
    }

    // --------------------------------------------------
    // Method(s)

    @SuppressWarnings("unchecked")
    protected void notifyObservers() {
        data.notifyObservers((T) this);
    }

    // --------------------------------------------------
    // Attribute(s)

    ConcreteObservable<T> data = new ConcreteObservable<T>();
}
