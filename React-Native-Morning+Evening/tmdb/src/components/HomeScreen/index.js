import React, {Component} from 'react';
import {
    View, 
    Text,
    Button,
    StyleSheet,
    SafeAreaView,
    FlatList,
    Image,
    ScrollView,
    Dimensions,
    TouchableOpacity
} from 'react-native';
import {globalStyle} from "../../themes/global";
import apis from "../../utils/api";
import AnimatedLinearGradient, {presetColors} from 'react-native-animated-linear-gradient';
import FlatListComponent from '../FlatListComponent';

let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class HomeScreen extends Component {

    constructor(props) {
        super(props);
        this.state = {
            discover: {},
            trending_movies: {},
            trending_shows: {},
        }
    }


    componentDidMount() {

        fetch(apis.DISCOVER_API, {
            method: 'GET',
            headers: {
                'Content-Type': 'multipart/form-data',
            },
            })
            .then((response) => {
                if(response.ok) {
                    response.json().then((responseJson) => {
                        // console.log(responseJson.results);
                        this.setState({discover: responseJson.results})
                    })
                } else {
                    if(response.status == 404) {
                    }
                    if(response.status == 500) {
                    }
                }
            })
            .catch((error) => {
        });

        fetch(apis.TRENDING_API_MOVIES, {
            method: 'GET',
            headers: {
                'Content-Type': 'multipart/form-data',
            },
            })
            .then((response) => {
                if(response.ok) {
                    response.json().then((responseJson) => {
                        console.log(responseJson);
                        this.setState({trending_movies: responseJson.results})
                    })
                } else {
                    if(response.status == 404) {
                    }
                    if(response.status == 500) {
                    }
                }
            })
            .catch((error) => {
        });

        fetch(apis.TRENDING_API_SHOWS, {
            method: 'GET',
            headers: {
                'Content-Type': 'multipart/form-data',
            },
            })
            .then((response) => {
                if(response.ok) {
                    response.json().then((responseJson) => {
                        console.log(responseJson.results);
                        this.setState({trending_shows: responseJson.results})
                    })
                } else {
                    if(response.status == 404) {
                    }
                    if(response.status == 500) {
                    }
                }
            })
            .catch((error) => {
        });

    }

    onPressTopRated = () => {
        this.props.navigation.navigate("Top Rated");
    }

    render(){
        return (
        <SafeAreaView style = {[globalStyle.background, {flex: 1, paddingLeft: 20,}]}>
            <ScrollView style = {[globalStyle.innerView,]}>
                <View style = {{alignItems: "center"}}>
                    <Image style = {{marginTop: 5, marginBottom: 30, width: 150, height: 20}} source = {require("../../assets/images/tmdb.png")}/>
                    {/* <Text style = {globalStyle.header}>Homepage</Text> */}
                    <TouchableOpacity onPress = {() => {this.onPressTopRated()}}>
                        <View style = {styles.gradientStyle}>
                            <AnimatedLinearGradient
                                // Button Linear Gradient
                                customColors={[ '#6EDEFF', '#32C1ED', '#1281DD']}
                                speed = {600}
                                points = {{
                                    start: {x: 1, y: 0.6}, 
                                    end: {x: 0, y: 0.4}
                                }}
                            >
                                <View style = {{flex: 1, justifyContent: "space-around", flexDirection: "row"}}>
                                    <Text style = {styles.innerGradientText}>Click to see the top rated movies!</Text>
                                    <Image style = {{ width: 25, height: 25, alignSelf: "center", tintColor: "white"}} source = {require("../../assets/images/chevron-right.png")} />
                                </View>
                            </AnimatedLinearGradient>
                        </View>
                    </TouchableOpacity>
                </View>
                <Text style = {styles.discoverHeader}>Discover</Text>
                {
                    this.state.discover?
                        <FlatListComponent list = {this.state.discover} navigation = {this.props.navigation} />
                    :
                        null
                }
                <Text style = {styles.discoverHeader}>Trending</Text>
                <Text style = {styles.trendingHeader}>Movies</Text>
                {
                    
                    this.state.trending_movies?
                        <FlatListComponent list = {this.state.trending_movies} navigation = {this.props.navigation} />
                    :
                        null
                }
                <Text style = {[styles.trendingHeader, {marginTop: 10}]}>Shows</Text>
                {
                    this.state.trending_shows?

                    <FlatListComponent list = {this.state.trending_shows} navigation = {this.props.navigation} />

                    :
                        null
                }
            </ScrollView>
            <View style = {{height: 20}}></View>
        </SafeAreaView>
        );
    }
}

const styles = StyleSheet.create({
    discoverHeader: {
        color: "white",
        fontFamily: "Poppins-Bold",
        fontSize: 20,
        marginTop: 15,
        marginBottom: 7,

    },
    posterStyle: {
        width: 110,
        height: 170,
        borderRadius: 6,
        overflow: 'hidden',
        marginRight: 10,
    },
    trendingHeader: {
        fontFamily: "Poppins-Bold",
        color: "white",
        fontSize: 16,
        marginBottom: 7,
    },
    flatListFooter: {
        width: 20,
    },
    flatListStyle: {
        marginLeft: -20
    },
    gradientStyle: {
        width: width - 40,
        height: 70,
        marginLeft: -20,
        borderRadius: 10,
        overflow: 'hidden',
    },
    innerGradientText: {
        fontSize: 14,
        fontFamily: "Poppins-Bold",
        color: "white",
        // textAlign: "center",
        marginTop: 25,
        marginLeft: 20,
    }

})
  
export default HomeScreen;

