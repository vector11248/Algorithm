import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {
        Map<Character,TrieNode> children;
        boolean endOfWord;

        //构造函数初始化
        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }

    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*Iterative implementation of insert into trie */

    //遍历实现插入
    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true;

        //该串已经到达末尾
        current.endOfWord = true;
    }

/*   recursive implementation of insert into trie*/

    private void insertRecursive(TrieNode current,String word,int index){
        //递归基
        if(index == word.length()){
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            node = new TrieNode();
            current.children.put(ch,node);
        }
        insertRecursive(node,word,index+1);

    }

    public void insertRecursive(String word){
        insertRecursive(root,word,0);
    }


    //遍历实现查找
    public boolean search(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    //递归实现查找
    private boolean searchRecursive(TrieNode current,String word,int index){
        //递归基
        if(index == word.length()){
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }
        return searchRecursive(node,word,index+1);
    }

    public boolean searchRecursive(String word){
        searchRecursive(root,word,0);
        return  true;
    }

    private boolean delete(TrieNode current,String word,int index){
        if(index == word.length()){
            //when reach the end of word only delete if
            //current.endOfWord is true.
            if(!current.endOfWord){
                return false;
            }
        }
        return true;
    }



}

