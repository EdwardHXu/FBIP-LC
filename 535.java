public class Codec {
    //FBIP 2R
    //design one-to-one matching method to encode and decode URL. 
    //use Random() to get randomized URL encoding method
    //use HashMap to store random number and corresponding URL
    HashMap<Integer, String> map = new HashMap();
    Random rand = new Random();
    int key = rand.nextInt(Integer.MAX_VALUE);
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key))
            key = rand.nextInt(Integer.MAX_VALUE);
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));