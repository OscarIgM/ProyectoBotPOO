package Bot;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;


public class ConexionFirebase implements Conexion {
    static Firestore bd;

    public void conectar() throws IOException {
        //https://console.firebase.google.com/u/2/project/base-de-datos-bot-de-ds/settings/serviceaccounts/adminsdk
        FileInputStream serviceAccount = new FileInputStream("dbfirebase.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        bd = FirestoreClient.getFirestore();
        System.out.println("Conexion exitosa");
    }

    @Override
    public boolean insertarDatosAnime(String documento, Map<String, Object> data) {
        try {
            DocumentReference docRef = bd.collection("Datos Anime").document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update time: " + result.get().getUpdateTime());
            return true;
        } catch (Exception e) {
            System.out.println("No se han podido insertar Datos");
        }
        return false;
    }


}
