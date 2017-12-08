public class FindDupFiles {
	private static MessageDigest messageDigest;

	private static final int BUFFER_SIZE = 1024*1024;

	public static void findDuplicateFiles(Map<String, List<String>> filesList, File directory) {
		for (File dirChild : directory.listFiles()) {
		// Iterate all file sub directories recursively
			if (dirChild.isDirectory()) {
				findDuplicateFiles(filesList, dirChild);
			} else {
				try {
					// Read file as bytes
					FileInputStream fileInput = new FileInputStream(dirChild);
					byte fileData[] = new byte[(int)dirChild.length()];
					fileInput.read(fileData);
					fileInput.close();
					//In the above code, we apply a notable secure hash function called SHA-512.
					//We will use this function to create a unique id for each of the files in the file system.
					//Using the SHA-512 encryption algorithm to encrypt the file data
					messageDigest = MessageDigest.getInstance("SHA-512");
					// Create unique hash for current file
					//convert it to hexadecimal format with toString(16)
					String uniqueFileHash = new BigInteger(1, messageDigest.digest(fileData)).toString(16);
					List<String> identicalList = filesList.get(uniqueFileHash);
					if (identicalList == null) {
					identicalList = new LinkedList<String>();
					}	
					// Add path to list
					identicalList.add(dirChild.getAbsolutePath());
					// push updated list to Hash table
					filesList.put(uniqueFileHash, identicalList);

				} catch (IOException e) {
					throw new RuntimeException("cannot read file " + dirChild.getAbsolutePath(), e);
				} catch (NoSuchAlgorithmException e) {
					throw new RuntimeException("cannot initialize SHA-512 hash function", e);
				}
			}
		}
	}

	public static void main(String[] args) {
		File dir = new File("/Users/zhy12345/Desktop/test");
		if (!dir.isDirectory()) {
			System.out.println("Supplied directory does not exist.");
			return;
		}
		Map<String, List<String>> lists = new HashMap<String, List<String>>();
		FindDupFiles.findDuplicateFiles(lists, dir);
		for (List<String> list : lists.values()) {
			if (list.size() > 1) {
				System.out.println("\n----duplicate files-----");
				for (String file : list) {
					System.out.println(file);
				}
			}
		}
		System.out.println("\n");
	}
}



public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<List<String>>();
        int n = paths.length;
        if (n == 0) return result;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String filename = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> filenames = map.getOrDefault(content, new HashSet<String>());
                filenames.add(filename);
                map.put(content, filenames);
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(new ArrayList<String>(map.get(key)));
            }
        }
        
        return result;
    }
}