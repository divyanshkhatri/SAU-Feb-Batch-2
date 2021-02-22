import React, {Component} from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import TopRatedScreen from '../TopRatedScreen';

const TopRatedStack = createStackNavigator();

function TopRatedComponent() {
  return (
    <TopRatedStack.Navigator>
        <TopRatedStack.Screen 
            name="Top Rated Movies" 
            component={TopRatedScreen} 
            options= {{headerBackTitleVisible: true, 
                headerBackTitleVisible: false, 
                headerTintColor: "white", 
                headerTitleStyle: {
                textAlign: "center",
                marginTop: 0,
                fontSize: 25,
                fontFamily: "Poppins-Black",
                fontWeight: '900',
                color: "white",
                },
                headerLeftContainerStyle: {
                marginLeft: 10,
                },
                headerStyle: {
                backgroundColor: 'black',
                borderWidth: 0,
                elevation: 0,
                shadowOpacity: 0,
                borderBottomWidth: 0,
                }
            }} 
        />
    </TopRatedStack.Navigator>
  );
}

export default TopRatedComponent;