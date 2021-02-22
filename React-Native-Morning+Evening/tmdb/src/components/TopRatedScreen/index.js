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
} from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';
import {globalStyle} from '../../themes/global';
import apis from '../../utils/api';


let width = Dimensions.get("window").width;
let height = Dimensions.get("window").height;

class TopRatedScreen extends Component {

    constructor(props) {
        super(props)
        this.onEndReachedCalledDuringMomentum = true;
        this.state = {
            top_rated: {},
            refreshing: false,
            page: 1,
            scrollBegin: false,
            lang: {
                "en": "English",
                "hi": "Hindi",
                "ja": "Japanese",
                "fr": "French",
                "it": "Italian",
            }
        }
    }

    componentDidMount() {
        this.topratedrequestAPI();
    }

    renderFooter = () => {
        console.og("Inside render footer method");
        if (this.state.refreshing) {
          return <ActivityIndicator size="large" color = "white" />;
        } else {
          return null;
        }
    };

    fetchMore = () => {
        console.log("inside fetch more");
        this.setState({
            refreshing: true, page: this.state.page+1
        }, () => {
            this.topratedrequestAPI();
        });
    };

    topratedrequestAPI = () => {
        console.log(this.state.page)
        console.log(apis.TOP_RATED+"&page="+this.state.page);
        fetch(apis.TOP_RATED+"&page="+this.state.page, {
            method: 'GET',
            headers: {
                'Content-Type': 'multipart/form-data',
            },
            })
            .then((response) => {
                if(response.ok) {
                    response.json().then((responseJson) => {
                        this.setState({refreshing: false})
                        console.log(responseJson.results);
                        this.setState({top_rated: responseJson.results})
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
    render() {

        return (
        <SafeAreaView style = {[globalStyle.background]}>
            <Text style = {[globalStyle.header, {fontSize: 12, color: "#4ACDF4", marginBottom: 10}]}>Click on a card to see the details!</Text>
            {   this.state.top_rated ? 
                <FlatList 
                    style = {styles.flatListStyle}
                    data = {this.state.top_rated}
                    showsHorizontalScrollIndicator = {false}
                    renderItem = {({item}) => {
                        const img_poster = "http://image.tmdb.org/t/p/w200" + item.poster_path
                        ;
                        return (
                        <TouchableOpacity onPress = {() => this.props.navigation.navigate("Details", {details: item})}>
                            <View style = {styles.flatListMainView}>
                                <View style = {{flexDirection: 'row'}}>
                                    <Image 
                                        style = {styles.posterStyle} 
                                        source = {{uri: img_poster}} 
                                    />
                                    <View style = {styles.detailsStyle}>
                                        <Text style = {styles.titleStyle}>
                                            {item.title}
                                        </Text>
                                        <Text style = {styles.releaseStyle}>Release - {item.release_date}</Text>
                                        <Text style = {styles.languageStyle}>
                                            {this.state.lang[item.original_language]}
                                        </Text>
                                        <View style = {{flexDirection: "row", justifyContent: "space-between",alignContent: "center"}}>
                                            <Text style = {styles.votingStyle}>{item.vote_average} ⭐</Text>
                                            <Text style = {styles.popularityStyle}>🔥 {Math.round(item.popularity)} %</Text>
                                        </View>
                                    </View>
                                </View>
                            </View>
                        </TouchableOpacity>
                    )}}
                    keyExtractor = {(item) => item.id.toString()}
                    ListHeaderComponent={<View style={styles.flatListFooter}></View>}
                    ListFooterComponent={<View style={styles.flatListFooter}></View>}
                    // ListFooterComponent={this.renderFooter}
                    refreshing={this.state.refreshing}
                    onEndReached={this.fetchMore}
                    onEndReachedThreshold={0.01}
                    onMomentumScrollBegin={() => { this.onEndReachedCalledDuringMomentum = false; }}
                />
                : 
                    null
            }
        </SafeAreaView>
        );
    }
}

const styles = StyleSheet.create({
    flatListFooter: {
        width: 20,
    },
    flatListStyle: {
        marginLeft: 20
    },
    posterStyle: {
        width: 100,
        height: 150,
    },
    titleStyle: {
        fontFamily: "Poppins-Bold",
        fontSize: 16,
        color: "#4ACDF4",
        marginTop: 10,
        marginLeft: 10,
        // marginRight: 50,
    },
    detailsStyle: {
        // marginRight: 90,
        width: width - 150,
        justifyContent: "space-between"
        // borderWidth: 2,
        // borderColor: 'white',
        // flexWrap: 'wrap'
    },
    votingStyle: {
        fontFamily: "Poppins-Black",
        color: "white",
        marginBottom: 10,
        marginLeft: 10,
    },
    languageStyle: {
        fontSize: 12,
        fontFamily: "Poppins-Bold",
        color: "white",
        marginLeft: 10,
    },
    popularityStyle: {
        fontFamily: "Poppins-Black",
        color: "white",
        marginBottom: 10,
        marginRight: 10,
    },
    releaseStyle: {
        fontFamily: "Poppins-Bold",
        color: "white",
        fontSize: 14,
        marginLeft: 10,
    },
    flatListMainView: {
        width: width - 50, 
        backgroundColor: "#1A1A1A", 
        marginTop: 10, 
        marginBottom: 10,
        borderRadius: 10,
        marginLeft: -20,
        overflow: "hidden",
        alignSelf: "center"
    }
})

export default TopRatedScreen;