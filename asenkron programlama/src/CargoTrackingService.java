import java.util.concurrent.CompletableFuture;

public class CargoTrackingService {


    public CompletableFuture<String> trackCargoAsync(String trackingNumber) {
        return CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(3000); // 3 saniye bekletin
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // api yazmak yerine mesaj yazyorum

            return "Kargo " + trackingNumber + " dağıtıma çıktı.";
        });
    }


    public void startCargoTracking(String trackingNumber) {
        CompletableFuture<String> trackFuture = trackCargoAsync(trackingNumber);
        trackFuture.thenAccept(result -> System.out.println(result));
    }

    public static void main(String[] args) {
        CargoTrackingService trackingService = new CargoTrackingService();
        trackingService.startCargoTracking("ABC123456789");
        System.out.println("Kargo takip sorgusu yapılıyor, lütfen bekleyin...");
    }
}
