class Solution {
public:
    string reverseWords(string s) {
    std::istringstream iss(s);
    std::vector<std::string> words;
    std::string word;

    // Split the string into words
    while (iss >> word) {
        words.push_back(word);
    }

    // Use a string stream to build the reversed string
    std::ostringstream oss;

    // Reverse loop to append words in reverse order
    for (int i = words.size() - 1; i >= 0; i--) {
        oss << words[i];
        if (i > 0) oss << ' ';
    }

    return oss.str();
    }
};