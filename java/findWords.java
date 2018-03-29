public class Solution {
    public String[] findWords(String[] words) {
        String[] keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<keyboard.length;i++){
            for(char c: keyboard[i].toCharArray()){
                map.put(c, i);
            }
        }
        
        List<String> result = new LinkedList<>();
        for(String s: words){
            if(s.isEmpty()) continue;
            int flag = map.get(s.toUpperCase().charAt(0));
            for(char c : s.toUpperCase().toCharArray()){
                if(map.get(c)!=flag){
                    flag = -1;
                    break;   
                }
            }
            if(flag!=-1) result.add(s);
        }
        return result.toArray(new String[0]);
    }
}