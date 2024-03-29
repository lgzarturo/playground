import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.apache.commons.codec.binary.Hex;
import org.hashids.Hashids;
import org.joda.time.DateTime;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;
import java.util.stream.LongStream;

public class ShortUUID {

	private static final UUID uuid = UUID.randomUUID();

	public static void main(String[] args) {
		standardUUID();
		System.out.println(" ");
		nanoId();
		System.out.println(" ");
		hashId();
		System.out.println(" ");
		hashIdFromHexa();
		System.out.println(" ");
		shortUUID();
		System.out.println(" ");
		shortUUIDFromUUIDToHexa();
		System.out.println(" ");
		shortUUIDFromFromTimestampToHexa();
		System.out.println(" ");
		secureRandomString();
		System.out.println(" ");
		secureRandomStringWithHexa();
		System.out.println(" ");
		customUUID();
	}

	/**
	 * Implementación de NanoId https://github.com/ai/nanoid#readme
	 * Port para java https://github.com/aventrix/jnanoid
	 * Require la librería
	 * 		- compile 'com.aventrix.jnanoid:jnanoid:2.0.0'
	 */
	public static void nanoId() {
		Random random = new Random();
		int size = 12;
		String id = NanoIdUtils.randomNanoId(random, NanoIdUtils.DEFAULT_ALPHABET, size);
		System.out.println("nanoId:" + id + ", size: "+ id.length());
	}

	/**
	 * Implementación de https://hashids.org/
	 * Require la librería
	 * 		- compile group: 'org.hashids', name: 'hashids', version: '1.0.3'
	 */
	public static void hashId() {
		Hashids hashids = new Hashids(uuid.toString());
		Long hotelId = 1L;
		Long accountId = 3L;
		Long agencyId = 2L;
		String id = hashids.encode(hotelId, accountId, agencyId);
		long[] numbers = hashids.decode(id);
		LongStream stream = Arrays.stream(numbers);
		System.out.println("hashId:" + id + ", size: "+ id.length());
		System.out.println("decoded values:");
		stream.forEach(System.out::println);
	}

	/**
	 * Implementación de https://hashids.org/
	 * Require la librería
	 * 		- compile group: 'org.hashids', name: 'hashids', version: '1.0.3'
	 */
	public static void hashIdFromHexa() {
		String data = "accountCode";
		String hexa = String.valueOf(Hex.encodeHex(data.getBytes(StandardCharsets.UTF_8)));
		Hashids hashids = new Hashids(uuid.toString());
		String idHex = hashids.encodeHex(hexa);
		System.out.println("hashHex:" + idHex + ", size: "+ idHex.length());
	}

	public static void standardUUID() {
		System.out.println("standardUUID:" + uuid.toString() + ", size: "+ uuid.toString().length());
	}

	/**
	 * Convierte la cadena en un long y después el long se representa en base 36, por default un long se puede representar con toString en base 10
	 */
	public static void shortUUID() {
		long longValue = ByteBuffer.wrap(uuid.toString().getBytes(), 0, uuid.toString().length()).getLong();
		//long longValue = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		String id = Long.toString(longValue, Character.MAX_RADIX); // Base 36
		//Long.toString(LongValue) //Base 10
		System.out.println("shortUUID:" + id + ", size: "+ id.length());
	}

	/**
	 *  Convierte la cadena en un long y después el long se representa en Hexa
	 */
	public static void shortUUIDFromUUIDToHexa() {
		long longValue = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		String id = Long.toHexString(longValue);
		System.out.println("shortUUIDFromUUIDToHexa:" + id + ", size: "+ id.length());
	}

	/**
	 *  Convierte el valor incremental de un timestamp en long y después el long se representa en Hexa
	 */
	public static void shortUUIDFromFromTimestampToHexa() {
		long longValue = DateTime.now().getMillis() / 1000L;
		String id = Long.toHexString(longValue);
		System.out.println("shortUUIDFromFromTimestampToHexa:" + id + ", size: "+ id.length());
	}

	/**
	 * Genera un valor aleatorio y la representa el resultado en base64 del buffer de 16 bytes
	 */
	public static void secureRandomString() {
		final SecureRandom random = new SecureRandom();
		final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		byte[] buffer = new byte[16];
		random.nextBytes(buffer);
		String id = encoder.encodeToString(buffer);
		System.out.println("secureRandomString:" + id + ", size: "+ id.length());
	}

	/**
	 * Genera un valor aleatorio y el resultado de la operación bit a bit lo convierte en la representación hexa del long
	 */
	public static void secureRandomStringWithHexa() {
		SecureRandom random = new SecureRandom();
		String id = Long.toHexString(Long.MIN_VALUE | random.nextLong());
		System.out.println("secureRandomStringWithHexa:" + id + ", size: "+ id.length());
	}

	/**
	 * Divide el uuid y codifica el array en base64
	 */
	public static void customUUID() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16);
		byteBuffer.putLong(uuid.getMostSignificantBits());
		byteBuffer.putLong(uuid.getLeastSignificantBits());

		String id = Base64.getUrlEncoder()
				.withoutPadding()
				.encodeToString(byteBuffer.array());
				//.replaceAll("[+/]", "-"); <- Sirve solo para getEncoder

		System.out.println("customUUID:" + id + ", size: "+ id.length());
	}

}
