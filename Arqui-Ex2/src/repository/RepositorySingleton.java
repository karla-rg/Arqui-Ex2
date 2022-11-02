package repository;

public class RepositorySingleton extends RepositoryAccount
{
    static private RepositorySingleton repository;

    private RepositorySingleton(){

    };

    public static RepositorySingleton getRepository() {
        if (repository == null) {
            repository = new RepositorySingleton();
        }
        return repository;
    }

}
