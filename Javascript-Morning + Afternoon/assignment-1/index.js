length = () => {
    document.getElementById("stringlength").innerHTML = "Length of the string is " + document.getElementById("string").value.length + ".";
    console.log(document.getElementById("string").value.length);
}

lowerupper = () => {
    document.getElementById("stringlowerupper").innerHTML =  "Lower Case: " + document.getElementById("string").value.toLowerCase() + 
    ", " + "Upper Case: " + document.getElementById("string").value.toUpperCase();
    console.log(document.getElementById("string").value.toUpperCase());
    console.log(document.getElementById("string").value.toLowerCase());
}

vowelsconsonants = () => {
    let s = document.getElementById("string").value;
    console.log(s);
    let strVowels = "";
    let strConsonants = "";
    let strOtherChars = "";
    let i;
    for(i = 0; i<s.length; i++){
        if (s.charAt(i) == "a" || 
            s.charAt(i) == "e" || 
            s.charAt(i) == "i" || 
            s.charAt(i) == "o" || 
            s.charAt(i) == "u") {
            strVowels += s.charAt(i) + ", ";
        } else if(s.charAt(i)>=0 && s.charAt(i) <= 9){
            strOtherChars += s.charAt(i) + ", ";
        } else if (s.charAt(i) != "a" || 
                s.charAt(i) != "e" || 
                s.charAt(i) != "i" || 
                s.charAt(i) != "o" || 
                s.charAt(i) != "u") {
            strConsonants += s.charAt(i) + ", ";
        }
    }
    console.log("Vowels are: " + strVowels);
    console.log("Consonants are: "+ strConsonants);
    console.log("Other characters are: " + strOtherChars);

    document.getElementById("stringvowelsconsonants").innerHTML = "Vowels are - " + strVowels + ". Consonants are " + strConsonants + ". Other characters are " + strOtherChars;
    
}

isnumber = () => {

    let s= document.getElementById("string").value;
    console.log(s);
    let i;
    for(i = 0; i<s.length; i++) {
        if(s.charAt(i) >=0 || s.charAt(i) <=9) {
            document.getElementById("stringisnumber").innerHTML = "The string has atleast one number."
            console.log("The string has atleast one number.");
            return;
        }
    }
    document.getElementById("stringisnumber").innerHTML = "The string has no numbers."
    console.log("The string has no numbers.");

}