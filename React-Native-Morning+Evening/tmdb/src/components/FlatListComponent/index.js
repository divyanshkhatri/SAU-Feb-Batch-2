import React, {Component} from 'react';
import {
    View, 
    FlatList, 
    Text,
    StyleSheet,
    TouchableOpacity,
    Image
} from 'react-native';

class FlatListComponent extends Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
        console.log(this.props.list);
    }

    render() {
        return (
            <View>
                <FlatList 
                    style = {styles.flatListStyle}
                    horizontal
                    data = {this.props.list}
                    showsHorizontalScrollIndicator = {false}
                    renderItem = {({item}) => {
                        const img_poster = "http://image.tmdb.org/t/p/w200" + item.poster_path;
                        return (
                        <TouchableOpacity onPress = {() => this.props.navigation.navigate("Details", {details: item})}>
                            <View>
                                <Image 
                                    style = {styles.posterStyle} 
                                    source = {{uri: img_poster}} 
                                />
                            </View>
                        </TouchableOpacity>
                    )}}
                    keyExtractor = {(item) => item.id.toString()}
                    ListHeaderComponent={<View style={styles.flatListFooter}></View>}
                    ListFooterComponent={<View style={styles.flatListFooter}></View>}
                />
            </View>
        )
    }
}

const styles = StyleSheet.create({
    flatListFooter: {
        width: 20,
    },
    flatListStyle: {
        marginLeft: -20
    },
    posterStyle: {
        width: 110,
        height: 170,
        borderRadius: 6,
        overflow: 'hidden',
        marginRight: 10,
    },
})

export default FlatListComponent;