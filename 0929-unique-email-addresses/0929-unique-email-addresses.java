class Solution {
    public int numUniqueEmails(String[] emails) {
        //2 functions:
        //formatted email: a) divide with @, b) get only the first part of +, c) replace . with ""
        //return the first@last
        //second fn : add it to hashset

        HashSet<String> set = new HashSet<>();

        for(String email : emails){
            String formatted = getFormatted(email);
            set.add(formatted);
        }

        return set.size();
    }

    public String getFormatted(String email){
        String[] divideat = email.split("@");
        String localname = divideat[0];
        String domainname = divideat[1];

        String[] localnamewithplus = localname.split("\\+");

        String localnamewithoutplus = localnamewithplus[0];

        String firstname = localnamewithoutplus.replace(".", "");

        return firstname+"@"+domainname;
    }

}