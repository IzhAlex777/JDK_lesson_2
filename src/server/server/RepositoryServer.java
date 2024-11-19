package server.server;

public interface RepositoryServer {
    String getLog();
    void saveInLog(String text);
}
