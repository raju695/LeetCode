// import java.util.HashMap;

// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {

//         HashMap<Character, Integer> hm = new HashMap<>();

//         // Count characters in magazine
//         for (int i = 0; i < magazine.length(); i++) {
//             char ch = magazine.charAt(i);
//             hm.put(ch, hm.getOrDefault(ch, 0) + 1);
//         }

//         // Check characters needed for ransomNote
//         for (int i = 0; i < ransomNote.length(); i++) {
//             char ch = ransomNote.charAt(i);

//             int count = hm.getOrDefault(ch, 0);

//             if (count == 0) {
//                 return false;
//             }

//             hm.put(ch, count - 1);
//         }

//         return true;
//     }
// }

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count characters in magazine
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        // Consume characters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';

            if (freq[index] == 0) {
                return false;
            }

            freq[index]--;
        }

        return true;
    }
}