/*
Juan Carlos Ortiz de Montellano Bochelén
Morse.Java
This programm will read and decript a message in morse code
*/

public class Morse
{
	public static void main(String[] args)
	{
		String codedText = "1011101000101010111011100011101010001010101110111000000010111000111010001110101000000011101011101000101010101110001011101110100011101110111000000010111000101110100010000000111010001110111011100011100000001110001010101000100000001110101000101110100011101110111000101000111010100010101000000011101011101110001110111011100010101110000000101110001011101000100000001011101010001110111011100011101110111000111010111000101000111010001110111010000000101011101000111011101110001011101";
		decode(codedText);
	}
	public static void decode (String codedText)
	{
		String[] abcd = new String[26];
		abcd[0] = "10111";//a
		abcd[1] = "111010101";//b
		abcd[2] = "11101011101";//c
		abcd[3] = "1110101";//d
		abcd[4] = "1";//e
		abcd[5] = "101011101";//f
		abcd[6] = "111011101";//g
		abcd[7] = "1010101";//h
		abcd[8] = "101";//i
		abcd[9] = "1011101110111";//j
		abcd[10] = "111010111";//k
		abcd[11] = "101110101";//l
		abcd[12] = "1110111";//m
		abcd[13] = "11101";//n
		abcd[14] = "11101110111";//o
		abcd[15] = "10111011101";//p
		abcd[16] = "1110111010111";//q
		abcd[17] = "1011101";//r
		abcd[18] = "10101";//s
		abcd[19] = "111";//t
		abcd[20] = "1010111";//u
		abcd[21] = "101010111";//v
		abcd[22] = "101110111";//w
		abcd[23] = "11101010111";//x
		abcd[24] = "1110101110111";//y
		abcd[25] = "11101110101";//z

		String[] numb = new String[10];
		numb[0] = "1110111011101110111";//0
		numb[1] = "10111011101110111";//1
		numb[2] = "101011101110111";//2
		numb[3] = "1010101110111";//3
		numb[4] = "10101010111";//4
		numb[5] = "0101010101";//5
		numb[6] = "11101010101";//6
		numb[7] = "1110111010101";//7
		numb[8] = "111011101110101";//8
		numb[9] = "11101110111011101";//9

		//System.out.println(codedText);
		String[] words = codedText.split("0000000");//this separates the encoded message into words
		String sentence = "";
		for(int x = 0; x< words.length; x++)
		{
		//System.out.println(words[x]);//this prints the words encoded
			String word = words[x];
			String[] letters = word.split("000");//this separates the words into letters

			String realWord = "";

			for(int y = 0; y< letters.length; y++)
			{
				//System.out.println(letters[y]);//this prints the letters encoded
				String letter = letters[y];
				int abc = findLet(letter, abcd);
				//System.out.println(abc);//this prints the letters

				int NB = findNum(letter, numb);
				//System.out.print(NB+" ");//this prints the numbers in the letters


				int sum = (abc+NB);//this combine the numbers from both, numbers and letters
				//System.out.print(sum+" ");

				String f = "";
				int a=sum;
				char b = (char)a;
				f+=b;
				realWord += f;//this piece of code gives the characters from ASCII into regular characters "the final"
			}
			sentence += realWord + " ";
		}
		System.out.println(sentence);
	}

	public static int findLet(String letter, String[] morseletter)
	{
		for (int h = 0; h < morseletter.length; h++)
		{
			if (morseletter[h].equals(letter))// the "H inside indicates that it needs to give back the number of the character"
			{
				h = h+66;
				return h;//gives back the values + 65 to get ASCII
			}
		}
		return -1; //not found
	}

	public static int findNum(String letter, String[] morsenumber)
	{
		for (int h = 0; h < morsenumber.length; h++)
		{
			if (morsenumber[h].equals(letter))
			{
				h = h+49;
				return h;
			}
		}
		return -1;
	}
}
