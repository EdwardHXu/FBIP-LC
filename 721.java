class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //FBIP 2R
        //typical union-find problem: if email has the same union then merge them
        List<List<String>> result = new ArrayList();
        if (accounts == null)   return result;
        Map<String, String> owner = new HashMap();      //store email and its owner <email, username>
        Map<String, String> parent = new HashMap();     //use union-find to get the parent of current email <email, parent>
        Map<String, TreeSet<String>> union = new HashMap(); //use TreeSet to sort String in set and union is <parent, emails>
        
        for (List<String> list : accounts){             //initialize parent and owner
            for (int i = 1; i < list.size(); i++){      //start from 1 means only operates email (index 0 is username)
                owner.put(list.get(i), list.get(0));
                parent.put(list.get(i), list.get(i));
            }
        }
        for (List<String> list : accounts){             //use union-find to update parent as the first email
            String p = find(list.get(1), parent);
            for (int i = 2; i < list.size(); i++)
                parent.put(find(list.get(i), parent), p);
        }
        for (List<String> list : accounts){
            for (int i = 1; i < list.size(); i++){
                String p = find(list.get(i), parent);
                if (!union.containsKey(p))
                    union.put(p, new TreeSet());
                union.get(p).add(list.get(i));          //have to use sorted set to avoid duplicate
            }
        }
        for (String p : union.keySet()){
            List<String> emails = new ArrayList(union.get(p));
            emails.add(0, owner.get(p));
            result.add(emails);
        }
        return result;
    }
    private String find(String s, Map<String, String> p){
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}