import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;

public class GoogleAuthorizeUtil {
    private static final String APPLICATION_NAME = "Gopherwatch League Stats Application";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    /**
     *tokens directory will be created in your project when you will run this code first time.
     *you will find a file named StoredCredential, in this directory
     */
     private static final String TOKENS_DIRECTORY_PATH = "tokens";


     /**
     * Value of this SCOPES variable will decide the reading and writing rights of your bot.
     * Currently SPREADSHEETS_READONLY attribute is choosen which mean that our code can only read values from the spreadsheet.
     * For writing rights just use SPREADSHEETS in place of SPREADSHEETS_READONLY.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);

    // This variable is storing the path to your credentials.json file.
    private static final String CREDENTIALS_FILE_PATH = "/SPOILER_client_secret_651737569285-j4gr3na72o3unh1i4e0pq9ugnu531pqg.apps.googleusercontent.com.json";

    /**
     * The below code will generate a credential object.
     * */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleAuthorizeUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();


        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        final String spreadsheetId = "1tRHl68j9kqzJzScS0v9X3KdrS2UgycY0hvteI7_56xM";

        /**
        // Now you must define the range in which you want your application to read the data
        final String range = "HeroStats!A6:I6";

        List<List<Object>> values = Arrays.asList(
                Arrays.asList("BOON1E", "Winston", "12", "5", "8000", "10", "0", "14,653", "400")
                );
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption("RAW")
                        .execute();
         */
    }
}
