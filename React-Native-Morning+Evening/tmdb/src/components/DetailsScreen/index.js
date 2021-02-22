import React, {Component} from 'react';
import {
    View, 
    Text,
    Button,
    StyleSheet,
    SafeAreaView,
    FlatList,
    Image,
    Dimensions,
    ActivityIndicator,
    ScrollView,
} from 'react-native';
import {globalStyle} from '../../themes/global';
import language from '../../utils/globals/index';

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class DetailsScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            details: {}
        }
    }

    componentDidMount() {
        console.log(this.props.route.params.details);
        this.setState({details: this.props.route.params.details})
    }

    render() {
        let img_poster = "http://image.tmdb.org/t/p/w500";
        const {details} = this.state;
        let date = new Date(details.release_date).toUTCString();
        date = date.substr(5,11);
        return (
        <SafeAreaView style = {[globalStyle.background, {flex: 1}]}>
            { details ? 
            (
                <ScrollView style = {{marginLeft: 0, marginTop: 20}}>
                    <Image source = {{uri: img_poster+details.poster_path}} style = {styles.posterStyle}/>
                    {
                        details.title ? 
                        <Text style = {styles.titleStyle}>{details.title}</Text>
                        : 
                        <Text style = {styles.titleStyle}>{details.original_name}</Text>
                    }
                    <View style = {styles.popstarStyle}>
                        <Text style = {styles.languageStyle}>🔥 {Math.round(details.popularity)} %</Text>
                        <Text style = {styles.languageStyle}>{details.vote_average} ⭐</Text>
                    </View>
                    <Text style = {styles.overviewTextStyle}>Overview</Text>
                    <Text style = {styles.overviewStyle}>{details.overview}</Text>
                    <Text style = {styles.languageStyle}>Language - {language[details.original_language]}</Text>
                    <Text style = {styles.languageStyle}>Release Date - {date}</Text>
                    
                </ScrollView>
            )
            : null
            }
        </SafeAreaView>
        );
    }
}

const styles = StyleSheet.create({
    popstarStyle: {
        width: 180, 
        alignSelf: "center", 
        flexDirection: "row", 
        justifyContent: "space-around"
    },
    posterStyle: {
        alignSelf: "center", 
        width: 140, 
        height: 16*140/9,
        borderRadius: 10,
        borderWidth: 1,
        borderColor: "white"
    },
    titleStyle: {
        fontSize: 24,
        fontFamily: "Poppins-Bold",
        color: "#4ACDF4",
        textAlign: "center",
        marginTop: 20,
    },
    languageStyle: {
        fontSize: 18,
        fontFamily: "Poppins-Bold",
        color: "white",
        textAlign: "center",
        marginTop: 15,
    },
    overviewStyle: {
        color: "white",
        fontFamily: "Poppins-Bold",
        fontSize: 18,
        paddingLeft: 20,
        paddingRight: 20,
        textAlign: "center"
    },
    overviewTextStyle: {
        marginTop: 15, 
        fontFamily: "Poppins-Bold", 
        fontSize: 20, 
        color: "white",
        textAlign: "center",
        marginBottom: 10,
    }
})

export default DetailsScreen;