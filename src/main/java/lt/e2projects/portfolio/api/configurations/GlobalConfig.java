package lt.e2projects.portfolio.api.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({ FirebaseProperties.class })
public class GlobalConfig {

    private final FirebaseProperties firebaseProperties;

    @Bean()
    Firestore firestore() {
        return FirestoreClient.getFirestore();
    }

    @PostConstruct
    void initFirebase() throws IOException, NullPointerException {
        var resource = new ClassPathResource(firebaseProperties.getServiceAccountFile());
        var serviceAccount = new FileInputStream(new File(resource.getURI()));

        var firebaseOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(firebaseProperties.getDatabaseUrl())
                .build();

        FirebaseApp.initializeApp(firebaseOptions);
    }

}
