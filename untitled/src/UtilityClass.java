import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilityClass {

  public static String converStringToHash(String blockData) {
      StringBuilder hexString = new StringBuilder();
      try {
          byte[] ogBite = blockData.getBytes(StandardCharsets.UTF_8);
          System.out.println(ogBite.length+" "+ogBite);
          MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] encodedHash = digest.digest(blockData.getBytes(StandardCharsets.UTF_8));

          // Convert the byte array to a hexadecimal format

          for (byte b : encodedHash) {
              String hex = Integer.toHexString(0xff & b);
              if (hex.length() == 1) hexString.append('0');
              hexString.append(hex);
          }
          System.out.println("SHA-256 Hash: " + hexString.toString());
      } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
      }
      return hexString.toString();
  }
}
