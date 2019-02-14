package Knapsack;

import java.math.*;

public class Knapsack {
	public static void main(String[] args) {
		BigInteger m100 = new BigInteger("100");
		BigInteger m, w, Winv, tmp;
		BigInteger[] a = new BigInteger[47];
		BigInteger[] s = new BigInteger[63];
		BigInteger[] bin;
		BigInteger M = new BigInteger("2036764117802210446778721319780022003");
		BigInteger W = new BigInteger("127552671440279916013977");
		BigInteger two = new BigInteger("2");
		BigInteger[] input = new BigInteger[63];
		BigInteger[] input1 = new BigInteger[63];
		BigInteger[] apiTemp = new BigInteger[47];

		int[][] p = new int[63][47];
		int[][] p1 = new int[63][47];
		int[][] r = new int[63][47];
		int[][] r1 = new int[63][47];
		int[] api = new int[47];

		char[] plainText = new char[1000];

		char[] matrix = { ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1',
				'2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[',
				'\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', ' ', ' ', '\n', '\r', ' ' };
		BigInteger[] b = { new BigInteger("828454601004618054511235265"), new BigInteger("1275526714402799160140470"),
				new BigInteger("3312670429975509698800814637"), new BigInteger("1656016333309154149610372201"),
				new BigInteger("13893742515571039787771841019294860"),
				new BigInteger("3473435628637654604062400422795621"),
				new BigInteger("889199520958025639642433290598628846"),

				new BigInteger("52296595290514765565759270"), new BigInteger("414163524166588887297610609"),
				new BigInteger("434179453531874573717695084344185"), new BigInteger("1696012896940011282594980904743"),
				new BigInteger("54272431324770391323907127002638"),
				new BigInteger("1003303814254129854674414807716585400"),

				new BigInteger("25127876273735143454767259"), new BigInteger("1736717814255050966311060253390787"),
				new BigInteger("2006607628508769920034590735097226988"),
				new BigInteger("1520033966027851269047967363958268599"),
				new BigInteger("53000686036865110702156809440"), new BigInteger("27136216172595881423073227557507"),

				new BigInteger("102424795166544772559279741"), new BigInteger("27787485030504316218342282458519485"),
				new BigInteger("26500087913089674791246376626"), new BigInteger("868358906936196475995110252674323"),
				new BigInteger("55574970059222895036520646092842312"), new BigInteger("207273091090454863522826375"),

				new BigInteger("1778399041915158410584784621785159363"),
				new BigInteger("848006257140998480877616431301"), new BigInteger("217089727084818965459547332207210"),
				new BigInteger("6784054011260802495698327885865"),
				new BigInteger("444599760479267925164097205131342517"),

				new BigInteger("1916138160626024839044833662644574960"),
				new BigInteger("108544863669962154170053582117652"), new BigInteger("6122528229133435968674256"),
				new BigInteger("212001851278760360849215139431"), new BigInteger("13250299061887717955455216407"),

				new BigInteger("13568108277626947871956487799824"), new BigInteger("3392026941854065527709205935909"),
				new BigInteger("6946871257402861879565080761605289"),
				new BigInteger("1976451139214308971918937911086319567"),

				new BigInteger("222299880238677317546246503195565906"), new BigInteger("12755267144027991601404700"),
				new BigInteger("637763357201399580070235"), new BigInteger("111149940119976422130324651177853188"),
				new BigInteger("4081685486088957312449504"),

				new BigInteger("424002937241492080018934194580"), new BigInteger("6625851070636780517265685462"),
				new BigInteger("106000606757701579724817534598") };

		BigInteger[] cipherText = { new BigInteger("6766367818023128434540310598244499950"),
				new BigInteger("1560211866359360796066522096277217184"),
				new BigInteger("6536093836375556948954770105097597945"),
				new BigInteger("3610606981773003371630631194884555332"),
				new BigInteger("9295608315065040396373994486744168241"),
				new BigInteger("7615682732282749810148620287572643377"),
				new BigInteger("7169560423631830627178072630245030145"),
				new BigInteger("5685550568967118323397174935688595065"),
				new BigInteger("2565725986812302161470883394186184454"),
				new BigInteger("5864169107575369581151764061965722663"),
				new BigInteger("5964998822075030421150594348386180390"),
				new BigInteger("5140126602192650604800007045166263323"),
				new BigInteger("5853456727936184942671744990065380444"),
				new BigInteger("4808134243838305254322990141637600421"),
				new BigInteger("7506941164524955660275951751834020966"),
				new BigInteger("6366189872579964157687506561592238464"),
				new BigInteger("6657341522599101145959872383771747368"),
				new BigInteger("1929595096013745464464493884059476371"),
				new BigInteger("3656421534858286498192176621296930163"),
				new BigInteger("4990452360762189404756526173443907961"),
				new BigInteger("7602937939403253986814037475676224134"),
				new BigInteger("7250083486018673784258273539879903542"),
				new BigInteger("6536191264797760004259074360058536420"),
				new BigInteger("2644375905022441644275448850732517641"),
				new BigInteger("2678588075942675061843962567115042780"),
				new BigInteger("7700456190430271265075667049575425994"),
				new BigInteger("5893788450589626299238934739529480477"),
				new BigInteger("4578753999591473388958090663300063021"),
				new BigInteger("6508294220444918935444538121305306000"),
				new BigInteger("3643753252377681400590156304324995795"),
				new BigInteger("5384175848102704291133194470985120665"),
				new BigInteger("5117137085866817293289852378288797853"),
				new BigInteger("6483597729676178559380508745906567564"),
				new BigInteger("2410292057958347549907511337679472613"),
				new BigInteger("7312388934600910012253770467259672631"),
				new BigInteger("2687344737699083331861559405885959193"),
				new BigInteger("7135765124063160649984729246526032568"),
				new BigInteger("9370990757950104342835916743439746176"),
				new BigInteger("7875075694882852860065397238688027179"),
				new BigInteger("6807000664168932322448007605365168315"),
				new BigInteger("9559718586007895693731483309407700936"),
				new BigInteger("6919999131565978236827524963921681920"),
				new BigInteger("6893613060781013549731159659628853380"),
				new BigInteger("6373230393633363905142855068020816248"),
				new BigInteger("5972708585865674809392235432543439359"),
				new BigInteger("5743447912040405463766701167006090820"),
				new BigInteger("3632643256069710395405539341986114289"),
				new BigInteger("7102466298425020803952406277840178886"),
				new BigInteger("6763290259731962353450921260461961067"),
				new BigInteger("4904323639775437199286053826336784221"),
				new BigInteger("6907787996544364401889323334212656995"),
				new BigInteger("5752760440900333780603276615344198273"),
				new BigInteger("4980980041213917012383311306583571815"),
				new BigInteger("4736828004303829102188663809995803008"),
				new BigInteger("7648639630826006139911870310402458138"),
				new BigInteger("3409516859132918650458982642375005527"),
				new BigInteger("6448197674669476777405150711511801682"),
				new BigInteger("7867541166121406802961475277400443678"),
				new BigInteger("7215199833854414541239731248766682692"),
				new BigInteger("4701599670716049827772198966278650840"),
				new BigInteger("3330646134560851814958985950312497320"),
				new BigInteger("7709672460977402538198086388779217235"),
				new BigInteger("10003164368272733559012253212055405058") };

		m = M.nextProbablePrime();
		w = W.nextProbablePrime();
		Winv = w.modInverse(m);

		for (int i = 0; i < 47; i++) {
			apiTemp[i] = (b[i].multiply(Winv)).mod(m);
		}
		System.arraycopy(apiTemp, 0, a, 0, 47);

		for (int i = 0; i < 47; i++) {
			for (int j = i + 1; j < 47; j++) {
				if (a[i].compareTo(a[j]) > 0) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}

		for (int i = 0; i < 47; i++) {
			for (int j = 0; j < 47; j++) {
				if (a[i].compareTo(apiTemp[j]) == 0) {
					api[i] = j;
					break;
				}
			}
		}

		for (int i = 0; i < 63; i++) {
			s[i] = (Winv.multiply(cipherText[i])).mod(m);
		}
		for (int i = 0; i < 63; i++) {
			for (int j = 46; j >= 0; j--) {
				if (s[i].compareTo(a[j]) >= 0) {
					p[i][j] = 1;
					s[i] = s[i].subtract(a[j]);
				} else
					p[i][j] = 0;
			}
		}

		for (int i = 0; i < 63; i++) {
			int k = 0;
			for (int j = 46; j >= 0; j--) {
				p1[i][k] = p[i][j];
				k++;
			}
		}

		for (int i = 0; i < 63; i++) {
			for (int j = 0; j < 47; j++) {
				r[i][api[j]] = p[i][j];
			}
		}

		for (int i = 0; i < 63; i++) {
			int k = 0;
			for (int j = 46; j >= 0; j--) {
				r1[i][k] = r[i][j];
				k++;
			}
		}
		for (int i = 0; i < 63; i++)
			input[i] = BigInteger.ZERO;
		for (int i = 0; i < 63; i++) {
			int k = 0;
			for (int j = 46; j >= 0; j--) {
				if (r[i][j] == 1)
					input[i] = input[i].add(two.pow(k));
				k++;
			}
		}
		System.arraycopy(input, 0, input1, 0, 63);
		int j = 0;

		for (int i = 62; i >= 0; i--) {
			while (input[i].compareTo(m100) >= 0) {
				bin = input[i].divideAndRemainder(m100);
				input[i] = input[i].divide(m100);
				plainText[j] = matrix[bin[1].intValue()];
				j++;
				if (input[i].compareTo(m100) < 0) {
					plainText[j] = matrix[input[i].intValue()];
					j++;
				}
			}
		}
		for (int i = j - 1; i >= 0; i--)
			System.out.print(plainText[i]);
	}
}
